import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'http://localhost:3306/api', 
  withCredentials: false, 
  headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': `Bearer ${localStorage.getItem('token')}`
  }
});    

export default {
  getProductos(page, size) {
    return apiClient.get(`/productos?page=${page}&size=${size}`);
  },
  buscarProducto(nombre, page, size) {
    return apiClient.get(`/productos/buscar?nombre=${nombre}&page=${page}&size=${size}`);
  },
  registrarUsuario(usuario) {
    return apiClient.post('/usuarios/registrar', usuario);
  },
  login(usuario) {
    return apiClient.post('/auth/login', usuario);
  },
  obtenerOrdenes(page, size) {
    return apiClient.get(`/ordenes?page=${page}&size=${size}`);
  }
  
};

  