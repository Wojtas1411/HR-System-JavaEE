package ManagedBeans;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import entities.TemporaryPersonalDataEntity;

public class TemporaryPersonalDataEntityConverter implements Converter {

    public TemporaryPersonalDataEntityConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        TemporaryPersonalDataEntityManagedBean managedBean = (TemporaryPersonalDataEntityManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "temporaryPersonalDataEntity");

        final int id = Integer.parseInt(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof TemporaryPersonalDataEntity) {
            TemporaryPersonalDataEntity entity = (TemporaryPersonalDataEntity) object;

            final String pk = String.valueOf(entity.getId());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: TemporaryPersonalDataEntity");
        }
    }
}
