<template>
        <div class="flex flex-col items-center justify-center py-20 space-y-3">
            <h1>
                Hello, My Dear
            </h1>
            <img :src="`/images/${msg}.png`" />
        </div>

        <div class="flex flex-row items-center justify-center">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Password</th>
                        <th>Tasks</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="user in users" :key="user.id">
                        <td>{{ user.id }}</td>
                        <td>{{ user.name }}</td>
                        <td>{{ user.password }}</td>
                        <td>{{ user.tasks }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
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
console.log("The users: " + JSON.stringify(users))

</script>