package by.gourianova.binocularvision.dao.Sevice;

import by.gourianova.binocularvision.entity.Node;
import by.gourianova.binocularvision.entity.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private Stack<String> tagStack=new Stack<>();
    private static ArrayList<Node> nodeList=new ArrayList<>();

    public void parseOpenTag(String xmlInform) {

        Pattern xmlPatternStart = Pattern.compile("<[^/>]+>");
        Matcher xmlMatcher = xmlPatternStart.matcher(xmlInform);
        String openTag;

        while (xmlMatcher.find()) {
            int start = xmlMatcher.start();
            int end = xmlMatcher.end();
            openTag = xmlInform.substring(start, end);
            tagStack.push(openTag);
            createElement(tagStack, Tag.Open);
        }
    }

    public void parseDataTag(String xmlInform) {

        Matcher xmlMatcher =  Pattern.compile(">[^<]+[</]*").matcher(xmlInform);
        String dataTag;

        while (xmlMatcher.find()) {
            int start = xmlMatcher.start();
            int end = xmlMatcher.end();
            if (xmlInform.contains("</")) {
                dataTag = xmlInform.substring(start + 1, end - 2);
            } else {
                dataTag = xmlInform.substring(start + 1);
            }
            tagStack.push(dataTag);
            createElement(tagStack, Tag.Data);
        }
    }

    public void parseCloseTag(String xmlInform) {

        Pattern xmlPatternEnd = Pattern.compile("</[^>]+>");
        Matcher xmlMatcher = xmlPatternEnd.matcher(xmlInform);
        String closeTag;
        while (xmlMatcher.find()) {
            int start = xmlMatcher.start();
            int end = xmlMatcher.end();
            closeTag = xmlInform.substring(start, end);
            tagStack.push(closeTag);
            createElement(tagStack, Tag.Close);
        }
    }

    private void createElement(Stack<String> tagStack, Tag typeTag) {
        if (typeTag.equals(Tag.Open)) {
            Node node = new Node(tagStack.peek());
            node.setAttributes(getAttributes(tagStack.peek()));
            nodeList.add(node);
        }

        if (typeTag.equals(Tag.Data)) {
            nodeList.get(nodeList.size() - 1).setContent(tagStack.peek());
        }

        List<Node> childNodes = new ArrayList<Node>();
        int step = 0;

        if (typeTag.equals(Tag.Close)) {
            for (int i = nodeList.size() - 1; i >= 0; i--) {
                if (nodeList.get(i).isSeen() && !nodeList.get(i).isAdded()) {
                    childNodes.add(0, nodeList.get(i));
                    nodeList.get(i).setAdd(true);
                }
                if (!nodeList.get(i).isSeen()) {
                    nodeList.get(i).setSeen(true);
                    break;
                }
                step++;
            }
            nodeList.get(nodeList.size() - 1 - step).setChildNodes(childNodes);
        }

    }

    private List<String> getAttributes(String xmlInform) {
              Matcher xmlMatcher =  Pattern.compile("\s+[^=]+=\"[^\"]+\"").matcher(xmlInform);
        List<String> attributes= new ArrayList<String>();
        while (xmlMatcher.find()) {
            int start = xmlMatcher.start();
            int end = xmlMatcher.end();
            attributes.add(xmlInform.substring(start, end).trim());
        }
        return attributes;
    }

    public static ArrayList<Node> getNodeList() {
        return nodeList;
    }
}