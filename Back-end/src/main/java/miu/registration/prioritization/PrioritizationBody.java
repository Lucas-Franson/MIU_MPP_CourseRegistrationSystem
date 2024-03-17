package miu.registration.prioritization;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class PrioritizationBody {

    public static final String ExampleBody = """
            {
              "blocks": [
                {
                  "1": 1,
                  "2": 2,
                  "3": 3,
                  "4": 4,
                  "blockId": 1
                },
                {
                  "1": 17,
                  "2": 18,
                  "3": 19,
                  "4": 20,
                  "blockId": 2
                },
                {
                  "1": 26,
                  "2": 27,
                  "3": 28,
                  "4": 29,
                  "blockId": 3
                },
                {
                  "1": 35,
                  "2": 36,
                  "3": 37,
                  "4": 38,
                  "blockId": 4
                }
              ]
            }""";
    private List<PriorityBlock> blocks;

    @Data
    public static class PriorityBlock {
        @Schema(example = "1")
        private long blockId;

        @Schema(example = "1")
        @JsonProperty(value = "1")
        private long one;

        @Schema(example = "2")
        @JsonProperty(value = "2")
        private long two;

        @Schema(example = "3")
        @JsonProperty(value = "3")
        private long three;

        @Schema(example = "4")
        @JsonProperty(value = "4")
        private long four;
    }
}