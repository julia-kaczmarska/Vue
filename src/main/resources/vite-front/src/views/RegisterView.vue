<script setup lang="ts">
import Footer from "@/components/templates/Footer.vue";
import Header from "@/components/templates/Header.vue";
import Register from "@/components/Register.vue";
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
                      <h3 class="font-weight-light my-4">Create Account</h3>
                      <div class="pb-md-4">Have an account? <a class="text-decoration-none" href="login">Go to login</a></div>
                    </div>
                    <div class="card-body">
                      <Register />
                    </div>
                    <div class="card-footer text-center py-3">
                      <div class="small"><a href="/">Go back to Dashbord</a></div>
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
