package ManagedBeans;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import entities.JobDataEntity;

public class JobDataEntityConverter implements Converter {

    public JobDataEntityConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        JobDataEntityManagedBean managedBean = (JobDataEntityManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "jobDataEntity");

        final int id = Integer.parseInt(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof JobDataEntity) {
            JobDataEntity entity = (JobDataEntity) object;

            final String pk = String.valueOf(entity.getId());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: JobDataEntity");
        }
    }
}
