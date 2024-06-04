<script setup lang="ts">
import axios from "axios";
import { DataTable } from 'simple-datatables';
import { nextTick, onMounted, ref, watch } from "vue";

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
interface InventoryItem {
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

const inventory = ref<InventoryItem[]>([]);
let dataTable: DataTable | null = null;

const getInventoryList = async () => {
  const response = await axios.get("http://localhost:8080/api/inventory");
  inventory.value = response.data.content;
  console.log(response.data.pagination)
}

const initializeDataTable = async () => {
  await nextTick();
  const tableElement = document.querySelector('#datatablesSimple') as HTMLTableElement;
  replaceButtonsWithLinks(tableElement);
  dataTable = new DataTable(tableElement, {
    perPageSelect: [5, 10, 20],
    paging: true,
    nextPrev: true,
  });
}

const replaceButtonsWithLinks = (table: HTMLTableElement) => {
  const thElements = table.querySelectorAll('th');
  thElements.forEach(th => {
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

onMounted(async () => {
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
    <div class="card-body">
      <div v-if="inventory.length > 0">
        <table id="datatablesSimple">
          <thead>
          <tr>
            <th><a>Name</a></th>
            <th>Species</th>
            <th>Quantity</th>
            <th>State</th>
            <th>Place</th>
            <th>Source</th>
            <th>Notes</th>
            <th>User</th>
            <th>Modified</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="item in inventory" :key="item.name">
            <td>{{ item.name }}</td>
            <td>{{ item.species }}</td>
            <td>{{ item.quantity }}</td>
            <td>{{ item.state }}</td>
            <td>{{ item.place?.name }}</td>
            <td>{{ item.source?.name }}</td>
            <td>{{ item.notes }}</td>
            <td>{{ item.user?.name }}</td>
            <td>{{ new Date(item.lastmod_time).toLocaleDateString("pl-PL") }}</td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>
