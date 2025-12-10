<template>
  <header class="fixed w-full z-50 bg-white shadow">
    <div class="flex justify-center items-center py-0 px-0 space-x-3">
      <img src="/favicon.ico" alt="Logo" class="h-10 w-10" />

      <nav class="md:flex text-cyan-700 font-semibold space-x-6">
        <NuxtLink to = "/" class="hover:text-cyan-900 transition">Юзеры</NuxtLink>
        <NuxtLink to = "/tasks" class="hover:text-cyan-900 transition">Таски</NuxtLink>
        <NuxtLink to = "/login" class="hover:text-cyan-900 transition">Логин</NuxtLink>
        <NuxtLink to = "/logout" class="hover:text-cyan-900 transition">Логаут</NuxtLink>
      </nav>

      </div>
  </header>
</template>


<script setup>
</script>