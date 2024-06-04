<script setup lang="ts">
import Footer from "@/components/templates/Footer.vue";
import { useAuthStore } from '@/stores/auth';
import { ref, reactive } from 'vue';
import Header from "@/components/templates/Header.vue";

let invalidCredentials = ref(false);
const user = reactive({
  username: '',
  password: '',
});

async function onSubmit() {
  if (user.username !== '' && user.password !== '') {
    try {
      await useAuthStore().login(user.username, user.password);
      invalidCredentials.value = false;
    } catch (error: any) {
      invalidCredentials.value = true;
    }
  }
}
console.log(invalidCredentials.value);
</script>

<template>
  <div id="layoutSidenav">
    <Header />
    <div id="layoutSidenav_content">
      <div id="layoutAuthentication">
        <div id="layoutAuthentication_content">
          <main>
            <div class="container">
              <div class="row justify-content-center">
                <div class="col-lg-5">
                  <div class="card shadow-lg border-0 rounded-lg mt-5">
                    <div class="card-header text-center">
                      <h3 class="font-weight-light my-4">Login</h3>
                      <div class="pb-md-4">Don't have an account yet? <a class="text-decoration-none" href="register">Sign up here</a></div>
                    </div>
                    <div class="card-body">
                      <form @submit.prevent="onSubmit">
                        <div class="form-floating mb-3">
                          <input class="form-control" id="inputUsername" maxlength="32" type="text" placeholder="Username" v-model="user.username" />
                          <label for="inputUsername">Username</label>
                        </div>
                        <div class="form-floating mb-3">
                          <input class="form-control" id="inputPassword" maxlength="32" type="password" placeholder="Password" v-model="user.password" />
                          <label for="inputPassword">Password</label>
                        </div>
                        <div class="d-flex align-items-center justify-content-center mt-4 mb-0">
                          <button type="submit" class="btn btn-primary w-25">Login</button>
                        </div>
                      </form>
                    </div>
                    <div class="card-footer text-center py-3">
                      <div class="small"><a href="/">Go back to Dashbord</a></div>
                    </div>
                  </div>
                  <div class="col-md-12 mt-5" v-if="invalidCredentials">
                    <div class="card bg-danger text-white mb-4 h-50">
                      <div class="card-body">Failed login</div>
                      <div class="card-footer d-flex align-items-center justify-content-between">
                        <a class="small text-white text-decoration-none">Invalid Credentials</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </main>
        </div>
        <div id="layoutAuthentication_footer">
          <Footer />
        </div>
      </div>
    </div>
  </div>
</template>
