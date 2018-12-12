package ManagedBeans;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import entities.UnitsEntity;

public class UnitsEntityConverter implements Converter {

    public UnitsEntityConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        UnitsEntityManagedBean managedBean = (UnitsEntityManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "unitsEntity");

        final int id = Integer.parseInt(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof UnitsEntity) {
            UnitsEntity entity = (UnitsEntity) object;

            //final String pk = String.valueOf(entity.getId());

            //return pk;
            return entity.getName();
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: UnitsEntity");
        }
    }
}
