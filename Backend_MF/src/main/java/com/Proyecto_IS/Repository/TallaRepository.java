package com.Proyecto_IS.Repository;

import com.Proyecto_IS.Entidades.Talla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TallaRepository extends JpaRepository<Talla, Long> {
}
