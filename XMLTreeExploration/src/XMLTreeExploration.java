import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * load an XMLTree object from an XML URL then extract various pieces of
 * information using the XMLTree methods and you output that information to the
 * console.
 *
 * @author Vivian Lu
 *
 */
public final class XMLTreeExploration implements XMLTree {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeExploration() {
    }

    /**
     * Output information about the middle child of the given {@code XMLTree}.
     *
     * @param xt
     *            the {@code XMLTree} whose middle child is to be printed
     * @param out
     *            the output stream
     * @updates out.content
     * @requires <pre>
     * [the label of the root of xt is a tag]  and
     * [xt has at least one child]  and  out.is_open
     * </pre>
     * @ensures <pre>
     * out.content = #out.content * [the label of the middle child
     *  of xt, whether the root of the middle child is a tag or text,
     *  and if it is a tag, the number of children of the middle child]
     * </pre>
     */
    private static void printMiddleNode(XMLTree xt, SimpleWriter out) {
        if (xt.isTag()) {
            int len = xt.numberOfChildren();
            int middleIndex = (0 + len - 1) / 2;
            out.println("the middle child's label is " + xt.label());
            if (xt.child(middleIndex).isTag()) {
                out.println("The middle child's label is a tag.");
                out.println("The middle child's number of children is "
                        + xt.child(middleIndex).numberOfChildren());
            } else {
                out.println("The middle child's label is a text.");
            }
        } else {
            out.println("Error.");
        }

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        XMLTree xml = new XMLTree1(
                "http://web.cse.ohio-state.edu/software/2221/web-sw1/"
                        + "extras/instructions/xmltree-model/columbus-weather.xml");
        //out.println(xml.toString());
        xml.display();

        //The Root
        if (xml.isTag()) {
            out.println("This root is a tag.");
            //The Children
            XMLTree results = xml.child(0);
            if (results.isTag()) {
                XMLTree channel = results.child(0);

                //One more Challenge:
                printMiddleNode(channel, out);

                //Output the number of children of the root of the XMLTree channel.
                out.println(
                        "The number of children of the root of the XMLTree channel: "
                                + channel.numberOfChildren());
                if (channel.isTag()) {
                    //The Attributes:
                    XMLTree astronomy = xml.child(0).child(0).child(10);
                    if (astronomy.hasAttribute("sunset")) {
                        out.println(
                                "the root of the astronomy XMLTree has an attribute named \"sunset\"");
                        ;
                        out.println("the value of attribute sunrise is "
                                + astronomy.attributeValue("sunset"));
                    } else {
                        out.println(
                                "the root of the astronomy XMLTree doesn't have an attribute named \"sunset\".");
                        ;
                    }
                    if (astronomy.hasAttribute("midday")) {
                        out.println(
                                "the root of the astronomy XMLTree has an attribute named \"midday\".");
                        ;
                        out.println("the value of attribute midday is "
                                + astronomy.attributeValue("midday"));
                    } else {
                        out.println(
                                "the root of the astronomy XMLTree doesn't have an attribute named \"midday\".");
                        ;
                    }

                    XMLTree title = channel.child(1);
                    if (title.isTag()) {
                        XMLTree titleText = title.child(0);
                        out.println("the label of the titleText XMLTree: "
                                + titleText.label());

                    }
                }
            }
        } else {
            out.println("This root is not a tag.");
        }
        out.println("The label of the root: " + xml.label());

        //"a little challenge:"
        out.print(xml.child(0).child(0).child(1).child(0).label());

        in.close();
        out.close();
    }

    @Override
    public Iterable<String> attributeNames() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String attributeValue(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public XMLTree child(int k) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub

    }

    @Override
    public void display(String title) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean hasAttribute(String name) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isTag() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String label() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int numberOfChildren() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }

}
