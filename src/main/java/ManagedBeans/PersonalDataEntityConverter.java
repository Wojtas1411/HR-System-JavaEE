package ManagedBeans;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import entities.PersonalDataEntity;

public class PersonalDataEntityConverter implements Converter {

    public PersonalDataEntityConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        PersonalDataEntityManagedBean managedBean = (PersonalDataEntityManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "personalDataEntity");

        final int id = Integer.parseInt(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof PersonalDataEntity) {
            PersonalDataEntity entity = (PersonalDataEntity) object;

            //final String pk = String.valueOf(entity.getId());

            //return pk;
            return entity.getFamilyName()+" "+entity.getFirstName();
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: PersonalDataEntity");
        }
    }
}
