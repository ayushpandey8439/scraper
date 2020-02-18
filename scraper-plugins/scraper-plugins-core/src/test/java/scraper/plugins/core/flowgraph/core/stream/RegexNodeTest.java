package scraper.plugins.core.flowgraph.core.stream;

import org.junit.Assert;
import org.junit.Test;
import scraper.api.node.Address;
import scraper.api.specification.ScrapeInstance;
import scraper.plugins.core.flowgraph.FlowUtil;
import scraper.plugins.core.flowgraph.api.ControlFlowGraph;

import static scraper.plugins.core.flowgraph.ResourceUtil.opt;
import static scraper.plugins.core.flowgraph.ResourceUtil.read;

public class RegexNodeTest {
    @Test
    public void regexAsStreamTest() throws Exception {
        ScrapeInstance spec = read("core/stream/regex-stream1.jf");
        ControlFlowGraph cfg = FlowUtil.generateControlFlowGraph(spec);

        Assert.assertEquals(5, cfg.getNodes().size());
        Assert.assertEquals(2, cfg.getEdges().size());

        Address firstNode = opt(() -> spec.getNode("<regex-stream1.start.1>")).getAddress();
        Assert.assertEquals(1, cfg.getIncomingEdges(firstNode).size());
        Assert.assertEquals(1, cfg.getOutgoingEdges(firstNode).size());
    }

    @Test
    public void regexAsCollectTest() throws Exception {
        ScrapeInstance spec = read("core/stream/regex-collect1.jf");
        ControlFlowGraph cfg = FlowUtil.generateControlFlowGraph(spec);

        Assert.assertEquals(5, cfg.getNodes().size());
        Assert.assertEquals(2, cfg.getEdges().size());

        Address firstNode = opt(() -> spec.getNode("<regex-collect1.start.1>")).getAddress();
        Assert.assertEquals(1, cfg.getIncomingEdges(firstNode).size());
        Assert.assertEquals(1, cfg.getOutgoingEdges(firstNode).size());
    }
}
