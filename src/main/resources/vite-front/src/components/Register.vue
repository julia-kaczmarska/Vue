<script setup lang="ts">
import {reactive} from "vue";
import axios from "axios";
import router from "@/router";

const user = reactive({
  email: '',
  username: '',
  password: '',
});

const onSubmit = async () => {
  try {
    const response = await axios.post('http://localhost:8080/auth/register', {
      email: user.email,
      name: user.username,
      password: user.password
    });

    if (response.status === 200) {
      router.push('/login');
    } else {
      throw new Error('Invalid credentials');
    }
  } catch (error: any) {
    console.error(error.message || 'An error occurred during registration.');
  }
}
</script>

<template>
  <form @submit.prevent="onSubmit"
        oninput='passwordConfirm.setCustomValidity(passwordConfirm.value !== password.value ? "Passwords do not match." : "")'>
    <div class="form-floating mb-3">
      <input class="form-control" id="inputEmail" type="email" minlength="9" maxlength="64" required placeholder="name@example.com" v-model="user.email" />
      <label for="inputEmail">Email address</label>
    </div>
    <div class="form-floating mb-3">
      <input class="form-control" id="inputUsername" minlength="3" maxlength="32" type="text" required placeholder="Username" v-model="user.username" />
      <label for="inputUsername">Username</label>
    </div>
    <div class="form-floating mb-3">
      <input class="form-control" id="inputPassword" minlength="3" maxlength="32" type="password" required placeholder="Password" v-model="user.password"  name="password"/>
      <label for="inputPassword">Password</label>
    </div>
    <div class="form-floating mb-3">
      <input class="form-control" id="inputPasswordConfirm" type="password" placeholder="Confirm password" required name="passwordConfirm"/>
      <label for="inputPasswordConfirm">Confirm Password</label>
    </div>
    <div class="d-flex align-items-center justify-content-center mt-4 mb-0">
      <button type="submit" class="btn btn-primary w-25">Register</button>
    </div>
  </form>
</template>