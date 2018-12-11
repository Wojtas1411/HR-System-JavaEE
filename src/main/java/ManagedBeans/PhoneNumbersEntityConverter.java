package ManagedBeans;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import entities.PhoneNumbersEntity;

public class PhoneNumbersEntityConverter implements Converter {

    public PhoneNumbersEntityConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        PhoneNumbersEntityManagedBean managedBean = (PhoneNumbersEntityManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "phoneNumbersEntity");

        final int id = Integer.parseInt(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof PhoneNumbersEntity) {
            PhoneNumbersEntity entity = (PhoneNumbersEntity) object;

            final String pk = String.valueOf(entity.getId());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: PhoneNumbersEntity");
        }
    }
}
