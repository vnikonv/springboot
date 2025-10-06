<template>
        <div class="flex flex-col items-center justify-center py-20 space-y-3">
            <h1>
                Hello, My Dear
            </h1>
            <img :src="`/images/${msg}.jpg`" />
        </div>

        <div class="flex flex-row items-center justify-center">
            <table class="">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Task</th>
                        <th>Description</th>
                        <th>User</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="task in task_table" :key="task.id">
                        <td>{{ task.id }}</td>
                        <td>{{ task.task }}</td>
                        <td>{{ task.description }}</td>
                        <td>{{ task.user }}</td>
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

const dtbs = await axios.get("http://localhost:8080/api/alltasks")
const task_table = dtbs.data
console.log("The tasks: " + JSON.stringify(task_table))

</script>