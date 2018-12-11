package ManagedBeans;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import entities.StaffCategoryEntity;

public class StaffCategoryEntityConverter implements Converter {

    public StaffCategoryEntityConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        StaffCategoryEntityManagedBean managedBean = (StaffCategoryEntityManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "staffCategoryEntity");

        final int id = Integer.parseInt(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof StaffCategoryEntity) {
            StaffCategoryEntity entity = (StaffCategoryEntity) object;

            final String pk = String.valueOf(entity.getId());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: StaffCategoryEntity");
        }
    }
}
