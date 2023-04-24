/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa05_da;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 *
 * @author zuley
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Long> {

    @Override
    public Empleado create(Empleado p) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        session.save(p);
        Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "Se conectó la BD...");
//            log.setLevel(Level.INFO,"Se guardo Empleado");
        t.commit();
        session.close();
        return p;
    }

    @Override
    public boolean delete(Long id) {
//        try ( Session session = HibernateUtil.getSession()) {
//            Transaction t = session.beginTransaction();
//            session.delete(p);
//            t.commit();
//        }
//        return p;
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        boolean res = false;
        Empleado empleado = findById(id);
        if (empleado == null) {
            res = false;

        } else {
            session.delete(empleado);
            res = true;
        }
        t.commit();
        session.close();
        return res;

    }

    @Override
    public Empleado update(Empleado p, Long id) {
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        Empleado empleado = findById(id);
        if (empleado != null) 
           session.update(empleado);
        
        t.commit();
        session.close();
        return empleado;
        
//        try ( Session session = HibernateUtil.getSession()) {
//            Transaction t = session.beginTransaction();
//            session.update(p);
//            t.commit();
//        }
//        return p;
    }

    @Override
    public List<Empleado> findAll() {
//        Session session = HibernateUtil.getSession();
//        try {
//            List<Empleado> empleado = session.createNativeQuery("Select * from empleados", Empleado.class).getResultList();
//            return empleado;
//        }catch (Exception e){
//            return null;
//        }finally {
//            session.close();
//        }
        List<Empleado> lstRes = null;
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();
        lstRes = session.createQuery("from empleados").list(); //HQL consulta de hibernate hacia postgres.
        t.commit();
        session.close();
        return lstRes;

//        t.commit();
//        session.close();

    }

    @Override
    public Empleado findById(Long id) {
        Empleado empleado = null;
        Session session = HibernateUtil.getSession();
        Transaction t = session.beginTransaction();//get busca e intenta dar con el resultado si no existe da null, el load es con excepciones.

        empleado = session.get(Empleado.class, id);//Regresar objeto typo empleado
        
        t.commit();
        session.close();
        return empleado;

//        try ( Session session = HibernateUtil.getSession()) {
//            Empleado empleado = session.get(Empleado.class, id);
//        }
    }
    //SPRINGBOOT BASADO EN METOOS ABSTRACTOS


}
