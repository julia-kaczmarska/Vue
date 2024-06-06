<script setup lang="ts">
import axios from "axios";
import { DataTable } from 'simple-datatables';
import { nextTick, onMounted, ref, watch } from "vue";
import router from "@/router";
import ServerError from "@/views/errors/ServerError.vue";

interface User {
  name: string;
  email: string;
}

interface Place {
  name: string;
}

interface Source {
  name: string;
}
export interface InventoryItem {
  id: number;
  name: string;
  species: string;
  quantity: number;
  state: string;
  notes: string;
  lastmod_time: string;
  user: User;
  place: Place;
  source: Source;
}

const role = ref('');
const inventory = ref<InventoryItem[]>([]);
let dataTable: DataTable | null = null;

const getInventoryList = async () => {
  const response = await axios.get("http://localhost:8080/api/inventory");
  inventory.value = response.data.content;
  console.log(response.data.pagination)
}

const formatDateTime = (dateTimeString: string) => {
  const dateTime = new Date(dateTimeString);
  const date = dateTime.toLocaleDateString('pl-PL');
  const time = dateTime.toLocaleTimeString('pl-PL');
  return `${date} ${time}`;
};

const initializeDataTable = async () => {
  await nextTick();
  const tableElement = document.querySelector('#datatablesSimple') as HTMLTableElement;
  replaceButtonsWithLinks(tableElement);
  dataTable = new DataTable(tableElement, {
    perPageSelect: [5, 10, 20],
    paging: false,
    nextPrev: true,
  });
}

const replaceButtonsWithLinks = (table: HTMLTableElement) => {
  const thElements = table.querySelectorAll('th');
  thElements.forEach(th => {
    th.classList.add('text-center');
    const buttonElement = th.querySelector('button');
    if (buttonElement) {
      const textContent = buttonElement.textContent;
      const aElement = document.createElement('a');
      aElement.className = "datatable-sorter";
      aElement.textContent = textContent;
      th.replaceChild(aElement, buttonElement);
    }
  });
}

const getStateClass = (state: string) => {
  switch(state.toLowerCase()) {
    case 'ok':
      return 'text-success';
    case 'borrowed':
      return 'text-warning';
    case 'damaged':
      return 'text-danger';
    default:
      return '';
  }
};

const editItem = (item: InventoryItem) => {
  router.push({
    name: 'ItemEdit',
    params: {
      id: item.id,
    },
    query: {
      name: item.name,
      species: item.species,
      quantity: item.quantity,
      state: item.state,
      notes: item.notes,
      place: item.place.name,
      source: item.source.name,
    }
  });
};

onMounted(async () => {
  const userJson = localStorage.getItem('user');
  if (userJson) {
    const user = JSON.parse(userJson);
    role.value = user.role;
  }
  await getInventoryList();
  await initializeDataTable();
})

watch(inventory, () => {
  initializeDataTable();
})
</script>


<template>
  <div class="card mb-4">
    <div class="card-header">
      <i class="fas fa-table me-1"></i>
      Inventory
    </div>
    <div class="card-body" v-if="inventory.length > 0">
      <div>
        <table id="datatablesSimple" class="text-center">
          <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Species</th>
            <th>Quantity</th>
            <th>State</th>
            <th>Place</th>
            <th>Source</th>
            <th>Notes</th>
            <th>Last Modified By</th>
            <th v-if="role === 'ADMIN'">Edit</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="item in inventory" :key="item.id">
            <td>{{ item.id }}</td>
            <td>{{ item.name }}</td>
            <td>{{ item.species }}</td>
            <td>{{ item.quantity }}</td>
            <td :class="getStateClass(item.state)">{{ item.state }}</td>
            <td>{{ item.place?.name }}</td>
            <td>{{ item.source?.name }}</td>
            <td>{{ item.notes }}</td>
            <td>{{ item.user?.name }} <br> {{ formatDateTime(item.lastmod_time) }}</td>
            <td v-if="role == 'ADMIN'">
              <button class="page-link" @click="editItem(item)"><i class="fa-regular fa-pen-to-square"></i></button>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div v-if="inventory.length == 0">
      <ServerError />
    </div>
  </div>
</template>