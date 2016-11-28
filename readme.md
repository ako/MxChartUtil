# Mx Chart Util

Mendix connector to create chartjs datasets from OQL.

## Examples

Chartjs widget for Mendix requires the following data structure:

 ![Chartjs datastructure][4]
 
You need to configure a microflow datasource in the widget that will create and return this data structure.

Using the Mx Chart Util module you can use a single action that will return the result of an OQL query in the required data structure.

 ![microflow][1]

The action requires the following parameters:
* OQL statement
* Root object for the data structure

 ![Action config][2]
 
Here's an example OQL. You need to query the following colunns:
* chartname
* xlabel
* xvalue
* yvalue
* color
* label
* sortingvalue

 ![OQL example][3]
 
### Dynamic charter

The project contains an example how you can use the OQL action to build dynamic charts.

Some screenshots:

 ![Specify entity and attributes for chart][5]

 ![Chart popup][6]
 
## Development

* runivy.cmd - download all dependencies
* runivy-export.cmd - download module export required dependencies

## Release history

* 0.1 -

 [1]: docs/images/chart-microflow.png
 [2]: docs/images/chart-action-config.png
 [3]: docs/images/oql-example.png
 [4]: docs/images/chartjs-datastructure.png
 [5]: docs/images/dynamic_charter.png
 [6]: docs/images/dynamic_charter_chart_popup.png