<template>
    <div>
      <h1>Lista de Productos</h1>
      <div v-if="loading">Cargando productos...</div>
      <div v-else>
        <ul>
          <li v-for="producto in productos" :key="producto.id">
            <h2>{{ Productos.nombre }}</h2>
            <img :src="producto.imagen_url" alt="Imagen del producto"/>
            <p>{{ Productos.descripcion }}</p>
            <p>Precio: {{ Productos.precio }}</p>
            <p>Talla: {{ Productos.Talla }}</p>
            <p>Stock: {{ Productos.stok }}</p>
          </li>
        </ul>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        productos: [],
        loading: true,
      };
    },
    created() {
      this.fetchProductos();
    },
    methods: {
      async fetchProductos() {
        try {
          const response = await axios.get('/productos');
          this.productos = response.data.content; 
          this.loading = false;
        } catch (error) {
          console.error('Error fetching products:', error);
        }
      },
    },
  };
  </script>
  
  <style scoped>
  /* Agrega estilos si es necesario */
  </style>
  