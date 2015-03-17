package org.jsoft.comm.servlet;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.util.Streams;

public class MultipartWrapper extends HttpServletRequestWrapper {
	private Map<String,String[]> params = null;
	
	
	public MultipartWrapper(HttpServletRequest request) {
		super(request);
		params = new HashMap<String, String[]>();
		setParams(request);
	}

	@SuppressWarnings("unchecked")
	private void setParams(HttpServletRequest request) {
		ByteArrayOutputStream baos = null;
		InputStream is = null;
		try {
			boolean isMul = ServletFileUpload.isMultipartContent(request);
			if(isMul) {
				ServletFileUpload upload = new ServletFileUpload();
				FileItemIterator iter = upload.getItemIterator(request);
				while(iter.hasNext()) {
					FileItemStream fis = iter.next();
					is = fis.openStream();
					if(fis.isFormField()) {
						setFormFiled(fis.getFieldName(),is);
					} else {
					
						baos = new ByteArrayOutputStream();
						int len = 0;
						byte[] buf = new byte[1024];
						while((len=is.read(buf))>0) {
						
							baos.write(buf, 0, len);
						}
						byte[] fs = baos.toByteArray();
						request.setAttribute("fs", fs);
						params.put(fis.getFieldName(), new String[]{fis.getName()});
					}
				}
			} else {
				params = super.getParameterMap();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(baos!=null) baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(is!=null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void setFormFiled(String fieldName, InputStream is) throws IOException {
		if(params.containsKey(fieldName)) {
			String[] vs = params.get(fieldName);
			vs = Arrays.copyOf(vs,vs.length+1);
			vs[vs.length-1] = Streams.asString(is);
		} else {
			params.put(fieldName, new String[]{Streams.asString(is)});
		}
		
	}

	@Override
	public String getParameter(String name) {
		String[] v = params.get(name);
		if(v!=null) {
			return v[0];
		}
		return null;
	}

	@Override
	public Map<String,String[]> getParameterMap() {
		return params;
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] v = params.get(name);
		if(v!=null) {
			return v;
		}
		return null;
	}

	
}
