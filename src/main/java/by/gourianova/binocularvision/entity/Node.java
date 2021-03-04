package by.gourianova.binocularvision.entity;

import java.util.List;
import java.util.Objects;

public class Node {
    private String name;
    private String content;
    private List<Node> childNodes;
    private List<String> attributes;

    private boolean isSeen;
    private boolean isAdded;

    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

    public boolean isAdded() {
        return true;
    }

    public void setAdd(boolean isAdded) {
        this.isAdded = isAdded;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean isSeen) {
        this.isSeen = isSeen;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Node> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<Node> childNodes) {
        this.childNodes = childNodes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Node node = (Node) obj;
        if (node.name.equals(name) && Boolean.compare(node.isSeen, isSeen) == 0
                && Boolean.compare(node.isAdded, isAdded) == 0 && node.attributes.equals(attributes)
                && node.childNodes.equals(childNodes))
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, content, isSeen, isAdded, childNodes, attributes);
    }
}
