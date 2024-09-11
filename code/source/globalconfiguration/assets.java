package globalconfiguration;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.softwareag.is.dynamicvariables.DynamicVariablesConfigException;
import com.softwareag.is.dynamicvariables.assets.IAsset;
// --- <<IS-END-IMPORTS>> ---

public final class assets

{
	// ---( internal utility methods )---

	final static assets _instance = new assets();

	static assets _newInstance() { return new assets(); }

	static assets _cast(Object o) { return (assets)o; }

	// ---( server methods )---




	public static final void describeAsset (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(describeAsset)>> ---
		// @sigtype java 3.5
		// [i] field:0:required type
		// [i] field:0:required assetId
		// pipeline
		
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	type = IDataUtil.getString( pipelineCursor, "type" );
		String	assetId = IDataUtil.getString( pipelineCursor, "assetId" );
		
		// pipeline
		
		List<IData> assetList = new ArrayList<IData>();
		
		
		
		try {
			IAsset describeAsset = com.softwareag.is.dynamicvariables.DynamicVariablesManager.instance().describeAsset(type, assetId);
			describeAsset.getPropertyGroups().stream().flatMap(g ->g.getProperties().stream()).forEach(p->{
				IData iData = IDataFactory.create();
				IDataCursor iDataCursor = iData.getCursor();
				IDataUtil.put( iDataCursor, "propertyKey", p.getPropertyKey() );
				IDataUtil.put( iDataCursor, "value", p.getValue() );
				iDataCursor.destroy();
				assetList.add(iData);
			});
			IData[]	assets = (IData[]) assetList.toArray(new IData[assetList.size()]);
			IDataUtil.put( pipelineCursor, "properties", assets );
		} catch (DynamicVariablesConfigException e) {
			e.printStackTrace();
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void disableAsset (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(disableAsset)>> ---
		// @sigtype java 3.5
		// [i] field:0:required type
		// [i] field:0:required assetId
		// --- <<IS-END>> ---

                
	}



	public static final void enableAsset (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(enableAsset)>> ---
		// @sigtype java 3.5
		// [i] field:0:required type
		// [i] field:0:required assetId
		// --- <<IS-END>> ---

                
	}



	public static final void listAsset (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(listAsset)>> ---
		// @sigtype java 3.5
		// [i] field:0:required type
		// [o] record:1:required assets
		// [o] - field:0:required assetId
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	type = IDataUtil.getString( pipelineCursor, "type" );
		try {
			List<IData> assetList = new ArrayList<IData>();
			List<IAsset> listAssets = com.softwareag.is.dynamicvariables.DynamicVariablesManager.instance().listAssets(type, "", null, null);
			listAssets.stream().forEach(p->{
				IData iData = IDataFactory.create();
				IDataCursor iDataCursor = iData.getCursor();
				IDataUtil.put( iDataCursor, "assetId", p.getAssetId() );
				iDataCursor.destroy();
				assetList.add(iData);
			});
			IData[]	assets = (IData[]) assetList.toArray(new IData[assetList.size()]);
			IDataUtil.put( pipelineCursor, "assets", assets );
		} catch (DynamicVariablesConfigException e) {
			e.printStackTrace();
		}
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void updateAsset (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(updateAsset)>> ---
		// @sigtype java 3.5
		// [i] field:0:required type
		// [i] field:0:required assetId
		// [i] field:2:required properties
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	type = IDataUtil.getString( pipelineCursor, "type" );
		String	assetId = IDataUtil.getString( pipelineCursor, "assetId" );
		String[][]	properties = IDataUtil.getStringTable( pipelineCursor, "properties" );
		Map<String, String> pdata = new HashMap<String, String>();
		for (String[] p : properties) {
			pdata.put(p[0], p[1]);
		}
		
		// pipeline
		
		try {
			com.softwareag.is.dynamicvariables.DynamicVariablesManager.instance().updateAsset(type, assetId, pdata);
		} catch (DynamicVariablesConfigException e) {
		}
		
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

