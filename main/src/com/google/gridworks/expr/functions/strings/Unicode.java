package com.google.gridworks.expr.functions.strings;

import java.util.Properties;

import org.json.JSONException;
import org.json.JSONWriter;

import com.google.gridworks.gel.Function;

public class Unicode implements Function {

    public Object call(Properties bindings, Object[] args) {
        if (args.length == 1 && args[0] != null) {
            Object o = args[0];
            String s = (o instanceof String) ? (String) o : o.toString();
            Integer[] output = new Integer[s.length()];
            for (int i = 0; i < s.length(); i++) {
                output[i] = s.codePointAt(i);
            }
            return output;
        }
        return null;
    }
    
    public void write(JSONWriter writer, Properties options)
        throws JSONException {
    
        writer.object();
        writer.key("description"); writer.value("Returns an array of strings describing each character of s in their full unicode notation");
        writer.key("params"); writer.value("string s");
        writer.key("returns"); writer.value("string");
        writer.endObject();
    }
}