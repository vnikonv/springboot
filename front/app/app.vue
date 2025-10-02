<template>
    <div class="flex flex-row gap-2 items-center justify-center min-h-screen">
        <h1>
            Hello, My Dear
        </h1>
        <img :src="`/images/${msg}.png`" />
    </div>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Password</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="user in users" :key="user.id">
                <td>{{ user.id }}</td>
                <td>{{ user.name }}</td>
                <td>{{ user.password }}</td>
            </tr>
        </tbody>
    </table>

</template>

<script setup lang="ts">
import { ref, onMounted } from "vue"
import axios from "axios"

const msg = ref<string>("")

// Function for fetching image name from backend when the component is mounted
onMounted(async () => {
    const res = await axios.get("http://localhost:8080/api/hello", { responseType: "text" })
    // Sending image name as text
    msg.value = res.data
})

const dtbs = await axios.get("http://localhost:8080/api/allusers")

const users = dtbs.data

</script>