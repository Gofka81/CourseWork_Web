package com.polyteh.taxi.tags;

import org.apache.log4j.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Custom tag for displaying copyright.
 *
 * @author L. Antonyk
 */
public class CopyrightTag extends TagSupport {
    private static final Logger LOGGER = Logger.getLogger(CopyrightTag.class);

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print("All rights are reserved 2022");
        } catch (Exception e) {
            LOGGER.error("Cannot start tag", e);
        }
        return SKIP_BODY;
    }
}
