using ArcGIS.Core.CIM;
using ArcGIS.Core.Data;
using ArcGIS.Core.Geometry;
using ArcGIS.Desktop.Catalog;
using ArcGIS.Desktop.Core;
using ArcGIS.Desktop.Editing;
using ArcGIS.Desktop.Extensions;
using ArcGIS.Desktop.Framework;
using ArcGIS.Desktop.Framework.Contracts;
using ArcGIS.Desktop.Framework.Dialogs;
using ArcGIS.Desktop.Framework.Threading.Tasks;
using ArcGIS.Desktop.KnowledgeGraph;
using ArcGIS.Desktop.Layouts;
using ArcGIS.Desktop.Mapping;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Map_Series_Tools
{
    internal class PrevPageButton: Button
    {
        protected override async void OnClick()
        {
            LayoutProjectItem lytItem = Project.Current.GetItems<LayoutProjectItem>()
                         .FirstOrDefault(item => item.Name.Contains("Profile"));

            await QueuedTask.Run(() =>
            {
                // Get layout
                Layout map_series_layout = lytItem.GetLayout();
                MapSeries MS = map_series_layout.MapSeries as MapSeries;

                // Set current page to next page 
                MS.SetCurrentPageNumber(MS.PreviousPageNumber);

            });
        }
    }
}
