package com.rustedbrain.util.test;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GridResourcesParser {

    private static final String PARSING_SITE_URL = "http://www.nordugrid.org/monitor/";
    private Pattern sitePattern = Pattern.compile("(host=)[a-z(-.)0-9]+(&amp)");
    private Pattern portPattern = Pattern.compile("(port=)[0-9]{1,5}");
    private Pattern flagPattern = Pattern.compile("(title=)\"Flag[a-z A-Z]+\"");
    private List<GridResource> gridResources;
    private Timer timer;

    public GridResourcesParser(int timerDelayInSeconds) {
        this.timer = new Timer(false);
        timer.schedule(new ResourceParsingTask(), new Date(System.currentTimeMillis()), TimeUnit.SECONDS.toMillis(timerDelayInSeconds));
    }

    public static void main(String[] args) {
        new GridResourcesParser(60);
    }

    public List<GridResource> getGridResources() {
        if (gridResources == null)
            this.gridResources = new ArrayList<>();
        return this.gridResources;
    }

    private class ResourceParsingTask extends TimerTask {

        @Override
        public void run() {
            String country = null;
            try {
                Document doc = Jsoup.connect(PARSING_SITE_URL).get();
                List<GridResource> gridResources = new ArrayList<>();
                Elements elements = doc.body().select("center").select("table").select("tbody").select("tr").select("td");
                for (Element element : elements) {
                    String flag = element.select("a").select("img").toString();
                    Matcher matcherFlag = flagPattern.matcher(flag);
                    if (matcherFlag.find()) {
                        country = flag.substring(matcherFlag.start(), matcherFlag.end()).replaceFirst("title=\"Flag of ", "").replaceFirst(" \"", "");
                    }

                    String text = element.toString();
                    Matcher matcherSite = sitePattern.matcher(text);
                    if (matcherSite.find()) {
                        String site = text.substring(matcherSite.start(), matcherSite.end()).replaceFirst("host=", "").replaceFirst("&amp", "");
                        GridResource gridResource = new GridResource();
                        gridResource.setCountry(country);
                        gridResource.setDomainName(site);
                        gridResources.add(gridResource);
                    }

                }
                Collections.sort(gridResources);
                GridResourcesParser.this.gridResources = gridResources;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class GridResource implements Comparable<GridResource> {

        private String domainName;
        private String country;
        private int port;

        public String getDomainName() {
            return domainName;
        }

        public void setDomainName(String domainName) {
            this.domainName = domainName;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        @Override
        public int compareTo(GridResource o) {
            return this.country.compareTo(o.getCountry());
        }

        @Override
        public String toString() {
            return "GridResource{" +
                    "domainName='" + domainName + '\'' +
                    ", country='" + country + '\'' +
                    ", port=" + port +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof GridResource)) return false;

            GridResource that = (GridResource) o;

            return port == that.port
                    && domainName.equals(that.domainName)
                    && (country != null ? country.equals(that.country) : that.country == null);

        }

        @Override
        public int hashCode() {
            int result = domainName.hashCode();
            result = 31 * result + (country != null ? country.hashCode() : 0);
            result = 31 * result + port;
            return result;
        }
    }
}
