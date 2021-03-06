/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jk.activiti.modeler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Tijs Rademakers
 */
@Controller
public class ModelEditorJsonRestResource implements ModelDataJsonConstants {

  protected static final Logger LOGGER = LoggerFactory.getLogger(ModelEditorJsonRestResource.class);

  @Autowired
  private RepositoryService repositoryService;

  @Autowired
  private ObjectMapper objectMapper;

  @ResponseBody
  @RequestMapping(value="modeler/model/{modelId}/json", method = RequestMethod.GET, produces = "application/json")
  public JSONObject getEditorJson(@PathVariable String modelId) {
    ObjectNode modelNode = null;
    Model model = repositoryService.getModel(modelId);

    JSONObject jsonObject=new JSONObject();
    if (model != null) {
      try {
        if (StringUtils.isNotEmpty(model.getMetaInfo())) {
          jsonObject= JSON.parseObject(model.getMetaInfo());
          modelNode = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
        } else {

          modelNode = objectMapper.createObjectNode();
          modelNode.put(MODEL_NAME, model.getName());
          jsonObject.put(MODEL_NAME,model.getName());
        }
        modelNode.put(MODEL_ID, model.getId());
        jsonObject.put(MODEL_ID,model.getId());
        ObjectNode editorJsonNode = (ObjectNode) objectMapper.readTree(
            new String(repositoryService.getModelEditorSource(model.getId()), "utf-8"));
        JSONObject jsonObject1=JSON.parseObject( new String(repositoryService.getModelEditorSource(model.getId()), "utf-8"));
         modelNode.put("model", editorJsonNode);
        jsonObject.put("model",jsonObject1);
      } catch (Exception e) {
        LOGGER.error("Error creating model JSON", e);
        throw new ActivitiException("Error creating model JSON", e);
      }
    }
//    jsonObject.put("data",modelNode);
    return jsonObject;
  }
}
