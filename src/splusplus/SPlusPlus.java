package splusplus;

import java.io.InputStream;
import java.net.URL;
import java.util.regex.Pattern;

public class SPlusPlus {

	public static void main(String[] args) throws Exception {
		/* Step 1: Download the Stats from the website */
		final URL url = new URL("https://github-readme-stats.vercel.app/api?username=MCPfannkuchenYT&theme=tokyonight");
		InputStream stream = url.openStream();
		String innerHTML = new String(stream.readAllBytes());
		/* Step 2: Update the Label to say S++ */
		String string1 = """
<text
            x="0"
            y="0"
            alignment-baseline="central"
            dominant-baseline="central"
            text-anchor="middle"
          >""";
		int index = innerHTML.lastIndexOf(string1);
		int endIndex = innerHTML.indexOf("</text>", index);
		String toReplace = innerHTML.substring(index, endIndex).split(">")[1].trim();
		innerHTML = innerHTML.replaceFirst(Pattern.quote(toReplace), "S++");
		/* Step 3: Delete the second circle */
		int midIndex2 = innerHTML.indexOf("class=\"rank-circle-rim\"");
		String[] list = innerHTML.substring(0, midIndex2).split("<");
		int index2 = innerHTML.indexOf("<" + list[list.length-1]);
		int endIndex2 = innerHTML.indexOf("/>", midIndex2);
		innerHTML = innerHTML.replaceFirst(innerHTML.substring(index2, endIndex2+2), "");
		/* Step 4: Update the first circle to go all around */
		String[] list2 = innerHTML.split("stroke-dashoffset: ");
		int index3 = innerHTML.lastIndexOf(list2[list2.length - 1]);
		int lastIndex3 = innerHTML.lastIndexOf(innerHTML.substring(index3).split(";")[1]);
		innerHTML = innerHTML.replaceFirst(innerHTML.substring(index3, lastIndex3-1), "0");
		/* Step 5: Save to STDOUT */
		System.out.println(innerHTML);
	}
	
}
