<script setup lang="ts">
import Footer from "@/components/templates/Footer.vue";

</script>

<template>
  <div id="layoutError">
    <div id="layoutError_content">
      <main>
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-6">
              <div class="text-center mt-4">
                <img class="mb-4 img-error" src="@/assets/img/error-404-monochrome.svg" alt="Not Found"/>
                <p class="lead">This requested URL was not found on this server.</p>
                <a href="/">
                  <i class="fas fa-arrow-left me-1"></i>
                  Return to Dashboard
                </a>
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
    <div id="layoutError_footer">
      <Footer />
    </div>
  </div>
</template>