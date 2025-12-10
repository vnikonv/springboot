<template>
        <div class="flex flex-col items-center justify-center py-10 space-y-3">
            <h1>
                This tab shows tasks of all users
            </h1>
            <img :src="`/images/${msg}.jpg`" />
        </div>

        <div class="flex flex-row items-center justify-center pb-20">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Task</th>
                        <th>Description</th>
                        <th>User</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="task in tasks" :key="task.id">
                        <td>{{ task.id }}</td>
                        <td>{{ task.tasks }}</td>
                        <td>{{ task.description }}</td>
                        <td>{{ task.username }}</td>
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
    const res = await axios.get("http://localhost:8080/api/hell", { responseType: "text" })
    // Sending image name as text
    msg.value = res.data
})

const dtbs = await axios.get("http://localhost:8080/api/task_dto")
const tasks = dtbs.data
console.log("The tasks: " + JSON.stringify(tasks))

</script>