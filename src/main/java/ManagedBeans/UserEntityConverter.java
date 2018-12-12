package ManagedBeans;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import entities.UserEntity;

public class UserEntityConverter implements Converter {

    public UserEntityConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        UserEntityManagedBean managedBean = (UserEntityManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "userEntity");

        //very slow hack
        for(UserEntity ue : managedBean.getEntities()){
            if(ue.getUsername().equals(string)){
                return managedBean.findEntity(ue.getId());
            }
        }

        final int id = Integer.parseInt(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof UserEntity) {
            UserEntity entity = (UserEntity) object;

            //final String pk = String.valueOf(entity.getId());

            //return pk;
            return entity.getUsername();
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: UserEntity");
        }
    }
}
