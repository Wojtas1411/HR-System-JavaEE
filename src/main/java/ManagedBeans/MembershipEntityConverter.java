package ManagedBeans;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import entities.MembershipEntity;

public class MembershipEntityConverter implements Converter {

    public MembershipEntityConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        MembershipEntityManagedBean managedBean = (MembershipEntityManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "membershipEntity");

        final int id = Integer.parseInt(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof MembershipEntity) {
            MembershipEntity entity = (MembershipEntity) object;

            final String pk = String.valueOf(entity.getId());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: MembershipEntity");
        }
    }
}
