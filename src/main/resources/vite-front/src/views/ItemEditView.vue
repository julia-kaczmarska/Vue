<script setup lang="ts">
import ItemEdit from "@/components/ItemEdit.vue";
import Header from "@/components/templates/Header.vue";
import Footer from "@/components/templates/Footer.vue";

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
                      <h3 class="font-weight-light my-4">Edit item</h3>
                    </div>
                    <div class="card-body">
                      <ItemEdit />
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