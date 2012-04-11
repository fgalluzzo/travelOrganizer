package pyt.auth.filter;

import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import pyt.constants.PageNames;
import pyt.mb.LoginMB;

public class LoggedUserFilter implements PhaseListener {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6185131486473677931L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Application app = ctx.getApplication();
		NavigationHandler handler = app.getNavigationHandler();
		String viewId = ctx.getViewRoot().getViewId();
		ValueExpression expression = app.getExpressionFactory()
				.createValueExpression(ctx.getELContext(),
						String.format("#{%s}", "LoginMB"), Object.class);

		LoginMB loginMB = (LoginMB) expression.getValue(ctx.getELContext());
		
		if(!loginMB.isLogged() && (!viewId.contains(PageNames.LOGIN_PAGE) && !viewId.contains(PageNames.SIGNUP_PAGE))) {
			
			handler.handleNavigation(ctx, null, PageNames.LOGIN_PAGE+"?faces-redirect=true");
			loginMB.setLastPage(viewId);
		} else {
			if(loginMB.isLogged() && (viewId.contains(PageNames.LOGIN_PAGE) || viewId.contains(PageNames.SIGNUP_PAGE))) {
				handler.handleNavigation(ctx, null, PageNames.HOME_PAGE+"?faces-redirect=true");
			}
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.RESTORE_VIEW;
	}

}
