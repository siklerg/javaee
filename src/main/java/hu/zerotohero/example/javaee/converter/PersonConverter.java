package hu.zerotohero.example.javaee.converter;

import hu.zerotohero.example.javaee.dao.BaseDao;
import hu.zerotohero.example.javaee.model.Person;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

public class PersonConverter implements Converter {

    @Inject
    BaseDao baseDao;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return baseDao.find(Person.class, Long.parseLong(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return ((Person) o).getId().toString();
    }

    //TODO hibakezelés!!!
}
