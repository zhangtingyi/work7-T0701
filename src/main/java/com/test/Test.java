package com.test;


import javax.management.Query;
import java.util.Iterator;
import java.util.List;

public class Test {
    public  static void main(String[] args){
//        Configuration configuration=new Configuration{}.configure();
//        SessionFactory sessionFactory=configuration.buildSessionFactory();
//        Session session=sessionFactory.openSession();
//
//        CarEntity carEntity=(CarEntity)session.get(CarEntity.class,1);
//        String name=carEntity.getName();
//
//        System.out.println(name);
//
//        Query query=session.createQuery("select name from CarEntity where id=:id");
//        query.setParameter("id",1);
//        List list=query.list();
//        Iterator iterator=list.iterator();
//        while(iterator.hasNext()){
//            carEntity=(CarEntity) iterator.next();
//            name=carEntity.getName();
//        }
//
//        CarEntity carEntity1=(CarEntity)session.load(CarEntity.class,1);
//        name=carEntity1.getName();
//        System.out.println(name);

//        Transaction transaction =session.beginTransaction();
//
//        for(int i=1;i<100000;i++){
//
//            CarEntity carEntity2=new CarEntity();
//            carEntity2.setName(i+""+i+i);
//
//            session.save(carEntity2);
//
//        }
//
//        transaction.commit();
//
//        Query query=session.createQuery("select count(1) from CarEntity");
//        List list=query.list();
//        Iterator iterator=list.iterator();
//
//        Long along=(Long) iterator.next();
//
//        System.out.println(along);
//
        Criteria criteria=session.createCirteria(CarEntity.class);
        criteria.setFirstReult(2);
        criteria.setMaxResults(1);

        List list1=criteria.list();
        Iterator iterator1=list1.iterator();

        CarEntity carEntity=null;

        while (iterator.hasNext()){
            CarEntity carEntity=(CarEntity)iterator.next();
            System.out.println(carEntity.getId+"1"+carEntity.getName());
        }

//        Transaction transaction =session.beginTransaction();

        carEntity.setName("sTest");
        session.update(carEntity);

//        transaction.commit();

//        session.flush();
        session.clear();

        session.evict(carEntity);

        int carid=carEntity.getId();
        CarEntity carEntity1=session.get(CarEntity.class,carid);

        String string=carEntity1.gertName();
        System.out.println(carid+"-"+string);

        session.close();
        sessionFactory.close();

    }
}
