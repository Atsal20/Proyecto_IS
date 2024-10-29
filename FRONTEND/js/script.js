fetchProductos(); {
    try {
      const response = await axios.get('http://localhost:5500/api/productos');
      console.log(response.data.content); // Muestra los productos en la consola
      this.productos = response.data.content; // Asigna los productos al array
      this.loading = false;
    } catch (error) {
      console.error('Error fetching products:', error);
    }
}
  