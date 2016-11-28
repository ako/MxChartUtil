// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package mxchartutil.actions;

import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.connectionbus.data.IDataRow;
import com.mendix.systemwideinterfaces.connectionbus.data.IDataTable;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.thirdparty.org.json.JSONArray;
import com.mendix.thirdparty.org.json.JSONObject;
import com.mendix.webui.CustomJavaAction;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class OQLChartDatasetJson extends CustomJavaAction<java.lang.String>
{
	private java.lang.String OQL;

	public OQLChartDatasetJson(IContext context, java.lang.String OQL)
	{
		super(context);
		this.OQL = OQL;
	}

	@Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
        ILogNode logger = Core.getLogger(OQLChartDatasetJson.class.getName());
        logger.info("> executeAction");
        IDataTable dataTable = Core.retrieveOQLDataTable(getContext(), this.OQL);
        JSONObject chart = new JSONObject();
        Iterator<IDataRow> iter = dataTable.iterator();
        HashMap<String, JSONObject> datasetMap = new HashMap<String, JSONObject>();
        JSONArray datasetArray = new JSONArray();
        int i = 0;
        while (iter.hasNext()) {
            IDataRow row = iter.next();
            if (i == 0) {
                chart.put("Name", row.getValue(getContext(), "chartname").toString());
                chart.put("CreationDate", new Date());
                chart.put("DataSets", datasetArray);
            }
            String label = row.getValue(getContext(), "label");
            if (!datasetMap.containsKey(label)) {
                JSONObject ds = new JSONObject();
                ds.put("label", label);
                ds.put("color", row.getValue(getContext(), "color").toString());
                Long sortingValue = row.getValue(getContext(), "sortingvalue");
                ds.put("sortingvalue", sortingValue.intValue());
                ds.put("datapoints", new JSONArray());
                datasetMap.put(label, ds);
                datasetArray.put(ds);
            }
            logger.debug(String.format("Row: %s, %s, %s, %f, %s, %s, %d",
                    row.getValue(getContext(), "chartname"),
                    row.getValue(getContext(), "xlabel"),
                    row.getValue(getContext(), "xvalue"),
                    row.getValue(getContext(), "yvalue"),
                    row.getValue(getContext(), "label"),
                    row.getValue(getContext(), "color"),
                    row.getValue(getContext(), "sortingvalue")
            ));

            JSONObject dp = new JSONObject();
            dp.put("yvalue", row.getValue(getContext(), "yvalue").toString());
            dp.put("xvalue", row.getValue(getContext(), "xlabel").toString());
            dp.put("xsortingvalue", row.getValue(getContext(), "xvalue").toString());
            datasetMap.get(label).getJSONArray("datapoints").put(dp);
            i++;
        }
        logger.info(String.format("Done creating charting dataseries, no rows found: %d", i));
        logger.info("< executeAction");
        return chart.toString();
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "OQLChartDatasetJson";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
