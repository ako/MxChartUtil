package system;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

import com.mendix.core.actionmanagement.IActionRegistrator;

@Component(immediate = true)
public class UserActionsRegistrar
{
  @Reference
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.bundleComponentLoaded();
    registrator.registerUserAction(appcloudservices.actions.GenerateRandomPassword.class);
    registrator.registerUserAction(appcloudservices.actions.LogOutUser.class);
    registrator.registerUserAction(appcloudservices.actions.StartSignOnServlet.class);
    registrator.registerUserAction(csvservices.actions.CsvExportInitializeAction.class);
    registrator.registerUserAction(csvservices.actions.ImportCsvData.class);
    registrator.registerUserAction(mxchartutil.actions.GetEntities.class);
    registrator.registerUserAction(mxchartutil.actions.GetEntityAttributes.class);
    registrator.registerUserAction(mxchartutil.actions.OQLChartDataset.class);
    registrator.registerUserAction(mxchartutil.actions.OQLChartDatasetJson.class);
    registrator.registerUserAction(mxchartutil.actions.OQLChartDatasetMapping.class);
    registrator.registerUserAction(system.actions.VerifyPassword.class);
  }
}
