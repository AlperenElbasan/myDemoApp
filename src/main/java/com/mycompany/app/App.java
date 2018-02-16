
package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
    public static boolean search(ArrayList<Integer> array, int e) {
      System.out.println("inside search");
      if (array == null) return false;

      for (int elt : array) {
        if (elt == e) return true;
      }
      return false;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            String value = sc1.next().replaceAll("\\s","");
            inputList.add(value);
          }
          String[] arr= inputList.toArray(new String[inputList.size()]);
          System.out.println("arr: "+Arrays.toString(arr));


	      String input11 = req.queryParams("input11");
          java.util.Scanner sc11 = new java.util.Scanner(input11);
          sc11.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList11 = new java.util.ArrayList<>();
          while (sc11.hasNext())
          {
            String value = sc11.next().replaceAll("\\s","");
            inputList11.add(value);
          }
          String[] arr11 = inputList11.toArray(new String[inputList11.size()]);
          System.out.println("arr11: "+Arrays.toString(arr11));


	      String input12 = req.queryParams("input12").replaceAll("\\s","");
          int input12AsInt = Integer.parseInt(input12);
          System.out.println("input12: "+input12AsInt);
          
          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);
	      System.out.println("input2: "+input2AsInt);

          String[] result = App.copyPaste(arr,arr11,input12AsInt,input2AsInt);
		  System.out.println("Result:" +Arrays.toString(result));

         Map map = new HashMap();
         map.put("result",Arrays.toString(result));
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }
    /**
	 * 
	 * Method which takes array a and b and 
	 * copy paste every String in the range of
	 * c < i < d as a[i] -> b[x], where initially x=0,
	 * and with each iteration x++.
	 * @author Alperen ELBASAN
	 * @since 2.16.2018
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return Changed copy-pasted b. 
	 * */
	public static String[] copyPaste(String[] a, String[] b, int c,int d){
		
		if(a == null)
			return null;
		if(b == null)
			return null;
		
		if(d-c+1 > b.length)
			return null;
		if(c > a.length)
			return null;
		
		for(int x =0, y=c; y <= d; y++, x++){
			b[x] = a[y];
		}
		
		return b;
	}

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

