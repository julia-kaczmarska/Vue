import router from '@/router';
import { defineStore } from 'pinia';

export const useAuthStore = defineStore({
    id: 'auth',
    state: () => ({
        user: localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')!) : null,
        returnUrl: '/'
    }),
    actions: {
        async login(name: string, password: string) {
            this.logout();
            const response = await fetch('http://localhost:8080/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ name, password })
            });

            if (!response.ok) {
                throw new Error('Invalid credentials');
            }

            const token = await response.text();
            const userInfoResponse = await fetch('http://localhost:8080/api/user/' + JSON.stringify(name).slice(1,-1), {
                method: 'GET',
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            });
            const [userInfo] = await userInfoResponse.json();

            const user = {
                email: userInfo.email,
                name: userInfo.name,
                role: userInfo.role,
                token: token
            };

            localStorage.setItem('user', JSON.stringify(user));
            this.user = user;
            console.log("user", user);

            await router.push('/');
        },
        logout() {
            console.log("Logging out...");
            localStorage.removeItem('user');
            this.user = null;
            router.push('/login');
        },
        isTokenExpired() {
            if(localStorage.getItem('user') != null) {
                const token = JSON.parse(localStorage.getItem('user')).token;
                const tokenData = JSON.parse(atob(token.split('.')[1])); // Splitting and decoding the token to get the payload
                const expirationTime = tokenData.exp * 1000; // Converting expiration time to milliseconds
                console.log(expirationTime)
                console.log("Expired? ", Date.now() >= expirationTime)
                if(Date.now() >= expirationTime) {
                    this.logout()
                }
            }
        }
    }
});
