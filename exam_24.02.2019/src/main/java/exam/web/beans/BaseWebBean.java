package exam.web.beans;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

@Named
@RequestScoped
public class BaseWebBean {
	protected ModelMapper modelMapper;

	/**
	 * If you use pretty faces library put the pattern element value attribute in
	 * the path. Example:
	 * 
	 * for
	 * 
	 * <pre>
	 * &lt;url-mapping id="index"&gt; &lt;pattern value="/" /&gt;
	 * &lt;view-id value="/faces/view/index.xhtml" /&gt; &lt;/url-mapping&gt;
	 * </pre>
	 * 
	 * <br/>
	 * in the path put "/"
	 * 
	 * @param path
	 * @throws IOException
	 */
	protected void redirect(String path) throws IOException {
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		ctx.redirect(ctx.getRequestContextPath() + path);
	}

	@Inject
	public BaseWebBean(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public BaseWebBean() {
	}
}