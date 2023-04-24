/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package org.uv.programa05_da;

import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author zuley
 */
public class Programa05_DA {

    public static void main(String[] args) {
      Session session = HibernateUtil.getSession();
        DAOEmpleado dao = new DAOEmpleado();
        Empleado empleado = new Empleado();
        empleado.setClave(11);
        empleado.setNombre("JJ");
        empleado.setDireccion("av. 11");
        empleado.setTelefono("246810");

        dao.create(empleado);

        System.out.println("--------------");
        
        empleado.setClave(12);
        empleado.setNombre("ANA");
        empleado.setDireccion("av. 14");
        empleado.setTelefono("12234");
        dao.delete(empleado);
        Logger.getLogger("DATO ELIMINADO");

        System.out.println("--------------");
        
        empleado.setClave(11);
        empleado.setNombre("ANA");
        empleado.setDireccion("av. 15");
        empleado.setTelefono("12234");
        dao.update(empleado);
        Logger.getLogger("DATO ACTUALIZADO");
        
        System.out.println("--------------");
        
        
    }
        

        
    }

