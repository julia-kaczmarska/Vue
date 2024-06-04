import { createRouter, createWebHistory } from 'vue-router'
import DashboardView from '@/views/DashboardView.vue'
import LoginView from '@/views/LoginView.vue'
import RegisterView from '@/views/RegisterView.vue'
import PageNotFound from "@/views/PageNotFound.vue";
import {useAuthStore} from "@/stores/auth";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Dashboard',
      component: DashboardView
    },
    {
      path: '/login',
      name: 'Login',
      component: LoginView
    },
    {
      path: '/logout',
      name: 'Logout',
      component: LoginView
    },
    {
      path: '/register',
      name: 'Register',
      component: RegisterView
    },
    { path: '/:pathMatch(.*)',
      component: PageNotFound }
  ]
})

router.beforeEach(async (to) => {
  const authPages = ['/login', '/register']
  const authRequired = authPages.includes(to.path);
  const auth = useAuthStore();

  if (authRequired && auth.user) {
    return '/';
  }
})

export default router
