package ManagedBeans;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import entities.AdresEntity;

public class AdresEntityConverter implements Converter {

    public AdresEntityConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        AdresEntityManagedBean managedBean = (AdresEntityManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "adresEntity");

        final int id = Integer.parseInt(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof AdresEntity) {
            AdresEntity entity = (AdresEntity) object;

            final String pk = String.valueOf(entity.getId());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: AdresEntity");
        }
    }
}
