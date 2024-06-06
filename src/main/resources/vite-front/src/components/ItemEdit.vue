<script setup lang="ts">
import { useRoute } from 'vue-router';
import { reactive, ref } from "vue";
import router from "@/router";

const route = useRoute();
const username = ref('');
const token = ref('');
const userJson = localStorage.getItem('user');
if (userJson) {
  const user = JSON.parse(userJson);
  username.value = user.name;
  token.value = user.token;
}

const itemData = reactive({
  id: route.params.id,
  name: route.query.name,
  species: route.query.species,
  quantity: route.query.quantity,
  state: route.query.state,
  notes: route.query.notes,
  place: route.query.place,
  source: route.query.source,
  user: {
    name: username.value
  }
});

const onSubmit = async () => {
  try {
    const response = await fetch(`http://localhost:8080/api/inventory/${itemData.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token.value}`,
      },
      body: JSON.stringify(itemData),
    });

    if (response.ok) {
      router.push('/');
    } else {
      console.error('Failed to update item');
    }
  } catch (error) {
    console.error('Network error:', error);
  }
};

document.addEventListener('DOMContentLoaded', function() {
  const textareas = document.querySelectorAll('.auto-expand');

  function adjustTextareaHeight(textarea: HTMLTextAreaElement) {
    textarea.style.height = 'auto';
    textarea.style.height = (textarea.scrollHeight + 2) + 'px';
  }

  textareas.forEach((textarea) => {
    textarea.addEventListener('input', function() {
      adjustTextareaHeight(this);
    });

    // Adjust height initially
    adjustTextareaHeight(textarea as HTMLTextAreaElement);
  });
});
</script>

<template>
  <form @submit.prevent="onSubmit">
    <div class="form-floating mb-3">
      <input class="form-control" id="inputName" maxlength="32" type="text" placeholder="Name" v-model="itemData.name" required />
      <label for="inputName">Name</label>
    </div>
    <div class="form-floating mb-3">
      <input class="form-control" id="inputSpecies" maxlength="32" type="text" placeholder="Species" v-model="itemData.species" required />
      <label for="inputSpecies">Species</label>
    </div>
    <div class="form-floating mb-3">
      <input class="form-control" id="inputQuantity" maxlength="32" type="number" placeholder="Quantity" v-model="itemData.quantity" required />
      <label for="inputQuantity">Quantity</label>
    </div>
    <div class="form-floating mb-3">
      <select class="form-select" aria-label="Default select example" v-model="itemData.state" required>
        <option disabled value="">Choose condition</option>
        <option :value="'OK'">OK</option>
        <option :value="'BORROWED'">BORROWED</option>
        <option :value="'DAMAGED'">DAMAGED</option>
      </select>
      <label>Condition</label>
    </div>
    <div class="form-floating mb-3">
      <select class="form-select" aria-label="Default select example" v-model="itemData.place" required>
        <option :value="'Pole 1'">Pole 1</option>
        <option :value="'Pole 2'">Pole 2</option>
        <option :value="'Tunel'">Tunnel</option>
      </select>
      <label>Place</label>
    </div>
    <div class="form-floating mb-3">
      <select class="form-select" aria-label="Default select example" v-model="itemData.source" required>
        <option :value="'Sklep Pana Mietka'">Sklep Pana Mietka</option>
        <option :value="'Ziarenko'">Ziarenko</option>
        <option :value="'Ogrodnictwo Moskała'">Ogrodnictwo Moskała</option>
        <option :value="'Miesiączek'">Miesiączek</option>
      </select>
      <label>Source</label>
    </div>
    <div class="form-floating mb-3">
      <textarea class="form-control auto-expand" id="inputNotes" maxlength="255" placeholder="Notes" v-model="itemData.notes"></textarea>
      <label for="inputNotes">Notes</label>
    </div>
    <div class="d-flex align-items-center justify-content-center mt-4 mb-0">
      <button type="submit" class="btn btn-primary w-25">Edit</button>
    </div>
  </form>
</template>