package controller;
import dao.PersonDao;
import model.Person;
import util.ListUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersonController extends HttpServlet {
private static final long serialVerUID=1L;
private static String INSERT_EDIT="/user.jsp";
private static String LIST_PERSON="/listUser.jsp";
private PersonDao dao=(PersonDao) PersonDao.getPersonList();;
    public PersonController() {
super();
       dao= (PersonDao) PersonDao.getPersonList();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello Servlet");
        String forward="dfg";
        String action=req.getParameter("action");
        if(action.equalsIgnoreCase("delete")){
            int id=Integer.parseInt(req.getParameter("userId"));
            dao.deletePerson(id);
            forward=LIST_PERSON;
            req.setAttribute("persons",dao.getAllPersons());
        }else if(action.equalsIgnoreCase("edit")){
            forward=INSERT_EDIT;
            int id=Integer.parseInt(req.getParameter("userId"));
            Person person=dao.getPersonById(id);
            req.setAttribute("person",person);
        }else if(action.equalsIgnoreCase("listPerson")){
            forward=LIST_PERSON;
            req.setAttribute("persons",dao.getAllPersons());
        }else {
            forward=INSERT_EDIT;
        }
        RequestDispatcher dispatcher=req.getRequestDispatcher(forward);
        dispatcher.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Person person=new Person();
        person.setFirstName(req.getParameter("firstName"));
        person.setLastName(req.getParameter("lastName"));
        person.setEmail(req.getParameter("email"));
        try {
            person.setData(new SimpleDateFormat("MM/dd/yyy").parse( req.getParameter("data")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
   String personID=req.getParameter("userId");
        if(personID==null||personID.isEmpty()){
            dao.addPerson(person);
        }else{
            person.setUserId(Integer.parseInt(personID));
            dao.update(person);
        }
   RequestDispatcher dispatcher=req.getRequestDispatcher(LIST_PERSON);
       req.setAttribute("persons",dao.getAllPersons());
        dispatcher.forward(req,resp);
    }
}
