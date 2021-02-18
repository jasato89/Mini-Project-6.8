package com.ironhack.reworkedgebanksystem.repository;

import com.ironhack.reworkedgebanksystem.controller.DTO.RoleDTO;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleDTO, Long> {
}
