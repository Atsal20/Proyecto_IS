login();{
  api.login(this.usuario)
    .then(response => {
      localStorage.setItem('token', response.data.token);
      this.$router.push('productos'); 
    })
    .catch(error => {
      console.error('Error al iniciar sesión:', error);
    });
}